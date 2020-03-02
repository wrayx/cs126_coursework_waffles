package uk.ac.warwick.cs126.stores;

import org.apache.commons.io.IOUtils;
import uk.ac.warwick.cs126.interfaces.ICustomerStore;
import uk.ac.warwick.cs126.models.Customer;
import uk.ac.warwick.cs126.structures.MyArrayList;
import uk.ac.warwick.cs126.util.DataChecker;
import uk.ac.warwick.cs126.util.StringFormatter;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerStore implements ICustomerStore {

    private MyArrayList<Customer> customerArray;
    private DataChecker dataChecker;
    private MyArrayList<Long> blackListedCustomerID;

    public CustomerStore() {
        // Initialise variables here
        customerArray = new MyArrayList<>();
        dataChecker = new DataChecker();
        blackListedCustomerID = new MyArrayList<>();
    }

    public Customer[] loadCustomerDataToArray(InputStream resource) {
        Customer[] customerArray = new Customer[0];

        try {
            byte[] inputStreamBytes = IOUtils.toByteArray(resource);
            BufferedReader lineReader = new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream(inputStreamBytes), StandardCharsets.UTF_8));

            int lineCount = 0;
            String line;
            while ((line=lineReader.readLine()) != null) {
                if (!("".equals(line))) {
                    lineCount++;
                }
            }
            lineReader.close();

            Customer[] loadedCustomers = new Customer[lineCount - 1];

            BufferedReader csvReader = new BufferedReader(new InputStreamReader(
                    new ByteArrayInputStream(inputStreamBytes), StandardCharsets.UTF_8));

            int customerCount = 0;
            String row;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

            csvReader.readLine();
            while ((row = csvReader.readLine()) != null) {
                if (!("".equals(row))) {
                    String[] data = row.split(",");

                    Customer customer = (new Customer(
                            Long.parseLong(data[0]),
                            data[1],
                            data[2],
                            formatter.parse(data[3]),
                            Float.parseFloat(data[4]),
                            Float.parseFloat(data[5])));

                    loadedCustomers[customerCount++] = customer;
                }
            }
            csvReader.close();

            customerArray = loadedCustomers;

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return customerArray;
    }

    public boolean addCustomer(Customer customer) {
        if (!dataChecker.isValid(customer) || blackListedCustomerID.contains(customer.getID())){
            return false;
        }
        if (this.getCustomer(customer.getID()) != null){
            blackListedCustomerID.add(customer.getID());
            customerArray.remove(this.getCustomer(customer.getID()));
            return false;
        }
        customerArray.add(customer);
        return true;
    }

    public boolean addCustomer(Customer[] customers) {
        boolean res = true;
        for (Customer customer : customers) {
            if (this.addCustomer(customer) == false)
                res = false;
        }
        return res;
    }

    public Customer getCustomer(Long id) {
        for (int i = 0; i < customerArray.size(); i++) {
            if (customerArray.get(i).getID().equals(id))
                return customerArray.get(i);
        }
        return null;
    }

    public Customer[] getCustomers() {
        Customer[] res = new Customer[customerArray.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = customerArray.get(i);
        }
        customerQuickSort(res, "id", 0, res.length - 1);
        return res;
    }


    private int idCompare(Customer c1, Customer c2) {
        return c1.getID().compareTo(c2.getID());
    }

    private int nameCompare(Customer c1, Customer c2){
        int firstNameCompare = c1.getFirstName().compareToIgnoreCase(c2.getFirstName());
        int lastNameCompare = c1.getLastName().compareToIgnoreCase((c2.getLastName()));
        if (firstNameCompare == 0 && lastNameCompare == 0)
            return idCompare(c1, c2);
        else if (lastNameCompare == 0)
            return firstNameCompare;
        else
            return lastNameCompare;
    }

    public void customerQuickSort(Customer[] array, String sortBy, int begin, int end) {
        if (begin < end) {
            int partitionIndex = 0;
            Customer pivot = array[end];
            int i = (begin - 1);

            for (int j = begin; j < end; j++) {
                int c = 0;

                if (sortBy.equalsIgnoreCase("name"))
                    c = nameCompare(array[j], pivot);
                else if (sortBy.equalsIgnoreCase("id"))
                    c = idCompare(array[j], pivot);

                if (c < 0) {
                    i++;

                    Customer tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }

            Customer tmp = array[i + 1];
            array[i + 1] = array[end];
            array[end] = tmp;

            partitionIndex = i + 1;

            customerQuickSort(array, sortBy, begin, partitionIndex - 1);
            customerQuickSort(array, sortBy, partitionIndex + 1, end);
        }
    }

    public Customer[] getCustomers(Customer[] customers) {
        Customer[] res = customers.clone();
        customerQuickSort(res, "id", 0, res.length - 1);
        return res;
    }

    public Customer[] getCustomersByName() {
        Customer[] res = new Customer[customerArray.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = customerArray.get(i);
        }
        customerQuickSort(res, "name", 0, res.length - 1);
        return res;
    }

    public Customer[] getCustomersByName(Customer[] customers) {
        customerQuickSort(customers, "name", 0, customers.length - 1);
        return customers;
    }

    public Customer[] getCustomersContaining(String searchTerm) {
        // ignore multiple spaces, only use the one space.
        if (searchTerm.length() == 0)
            return new Customer[0];
        String searchTermConverted = StringFormatter.convertAccentsFaster(searchTerm.replaceAll("\\s+", " "));
        MyArrayList<Customer> resList = new MyArrayList<>();
        if (searchTermConverted.contains("/s")) {
            String[] term = searchTermConverted.split("/s");
            String firstName = term[0];
            String lastName = term[1];

            for (int i = 0; i < customerArray.size(); i++) {
                if (customerArray.get(i).getFirstName().toLowerCase().contains(firstName.toLowerCase()) && customerArray.get(i).getLastName().toLowerCase().contains(lastName.toLowerCase()))
                    resList.add(customerArray.get(i));
            }
        } else {
            for (int i = 0; i < customerArray.size(); i++) {
                if (customerArray.get(i).getFirstName().toLowerCase().contains(searchTermConverted.trim().toLowerCase()) || customerArray.get(i).getLastName().toLowerCase().contains(searchTermConverted.trim().toLowerCase()))
                    resList.add(customerArray.get(i));
            }
        }

        Customer[] res = new Customer[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        customerQuickSort(res, "name", 0, res.length - 1);
        return res;
    }
}
