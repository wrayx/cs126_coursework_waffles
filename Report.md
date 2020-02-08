# CS126 WAFFLES Coursework Report [1234567]
<!-- This document gives a brief overview about your solution.  -->
<!-- You should change number in the title to your university ID number.  -->
<!-- You should delete these comments  -->
<!-- And for the latter sections should delete and write your explanations in them. -->
<!-- # <-- Indicates heading, ## <-- Indicates subheading, and so on -->

## CustomerStore
### Overview
<!-- A short description about what structures/algorithms you have implemented and why you used them. For example: -->
<!-- The template is only a guide, you are free to make any changes, add any bullets points, re-word it entirely, etc. -->
<!-- * <- is a bullet point, you can also use - minuses or + pluses instead -->
<!-- And this is *italic* and this is **bold** -->
<!-- Words in the grave accents, or in programming terms backticks, formats it as code: `put code here` -->
* I have used an `ArrayList` structure to store and process customers because it was easy to implement. 
* I used `BubbleSort` to sort customers by name and ID because I want my code to be inefficient. 

### Space Complexity
<!-- Write here what you think the overall store space complexity is and gives a brief reason why. -->
<!-- <br> gives a line break -->
<!-- In tables, you don't really need the spaces, it only makes it look nice in text form -->
<!-- You can just do "CustomerStore|O(n)|I have used a single `ArrayList` to store customers." -->
Store         | Worst Case | Description
------------- | ---------- | -----------
CustomerStore | O(n)       | I have used a single `ArrayList` to store customers. <br>Where `n` is total customers added.

### Time Complexity
<!-- Tell us the time complexity of each method and give a very short description. -->
<!-- These examples may or may not be correct, these examples have not taken account for other requirements like duplicate IDs and such.  -->
<!-- Again, the template is only a guide, you are free to make any changes. -->
<!-- If you did not do a method, enter a dash "-" -->
<!-- Technically, for the getCustomersContaining(s) average case, you are suppose to do it relative to s -->
<!-- Note, that this is using the original convertToAccents() method -->
<!-- So O(a*s + n*(a*t + t)) -->
<!-- Where a is the amount of accents -->
<!-- Where s is the length of the search term String  -->
<!-- Where t is the average length of a name -->
<!-- Where n is the total number of customers -->
<!-- But you can keep it simple -->

Method                           | Average Case     | Description
-------------------------------- | ---------------- | -----------
addCustomer(Customer c)          | O(1)             | Array add is constant time
addCustomer(Customer[] c)        | O(n)             | Add all customers <br>`n` is the length of the input array
getCustomer(Long id)             | O(n)             | Linear search <br>`n` is total customers in the store
getCustomers()                   | O(n^2)           | BubbleSort <br>`n` is total customers in the store
getCustomers(Customer[] c)       | O(n^2)           | BubbleSort <br>`n` is the length of the input array
getCustomersByName()             | O(n^2)           | BubbleSort <br>`n` is total customers in the store
getCustomersByName(Customer[] c) | -                | -
getCustomersContaining(String s) | O(a + n*(a + b)) | Searches all customers <br>`a` is the average time it takes to convert accents <br>`n` is total customers <br>`b` is average string search time

<!-- Don't delete these <div>s! -->
<!-- And note the spacing, do not change -->
<!-- This is used to get a page break when we convert your report to PDF to read when marking -->
<!-- It is not the end of the world if you do remove, it just makes it harder to read if you do -->
<!-- On things you can remove though, you should remember to remove these comments -->
<div style="page-break-after: always;"></div>

## FavouriteStore
### Overview
* I have used `...` to store favourites ... 
* I used `...` to sort ... 
* To get favourites by ... 
* To get ... 
* To get top ... 

### Space Complexity
Store          | Worst Case | Description
-------------- | ---------- | -----------
FavouriteStore | O(...)     | I have used `...` ... <br>Where `...` is ...

### Time Complexity
Method                                                          | Average Case     | Description
--------------------------------------------------------------- | ---------------- | -----------
addFavourite(Favourite f)                                       | O(...)           | Description <br>`...` is ...
addFavourite(Favourite[] f)                                     | O(...)           | Description <br>`...` is ...
getFavourite(Long id)                                           | O(...)           | Description <br>`...` is ...
getFavourites()                                                 | O(...)           | Description <br>`...` is ...
getFavourites(Favourite[] f)                                    | O(...)           | Description <br>`...` is ...
getFavouritesByCustomerID(Long id)                              | O(...)           | Description <br>`...` is ...
getFavouritesByRestaurantID(Long id)                            | O(...)           | Description <br>`...` is ...
getCommonFavouriteRestaurants(<br>&emsp; Long id1, Long id2)    | O(...)           | Description <br>`...` is ...
getMissingFavouriteRestaurants(<br>&emsp; Long id1, Long id2)   | O(...)           | Description <br>`...` is ...
getNotCommonFavouriteRestaurants(<br>&emsp; Long id1, Long id2) | O(...)           | Description <br>`...` is ...
getTopCustomersByFavouriteCount()                               | O(...)           | Description <br>`...` is ...
getTopRestaurantsByFavouriteCount()                             | O(...)           | Description <br>`...` is ...

<div style="page-break-after: always;"></div>

## RestaurantStore
### Overview
* I have used `...` to store restaurants ... 
* I used `...` to sort ... 

### Space Complexity
Store           | Worst Case | Description
--------------- | ---------- | -----------
RestaurantStore | O(...)     | I have used `...` ... <br>Where `...` is ...

### Time Complexity
Method                                                                        | Average Case     | Description
----------------------------------------------------------------------------- | ---------------- | -----------
addRestaurant(Restaurant r)                                                   | O(...)           | Description <br>`...` is ...
addRestaurant(Restaurant[] r)                                                 | O(...)           | Description <br>`...` is ...
getRestaurant(Long id)                                                        | O(...)           | Description <br>`...` is ...
getRestaurants()                                                              | O(...)           | Description <br>`...` is ...
getRestaurants(Restaurant[] r)                                                | O(...)           | Description <br>`...` is ...
getRestaurantsByName()                                                        | O(...)           | Description <br>`...` is ...
getRestaurantsByDateEstablished()                                             | O(...)           | Description <br>`...` is ...
getRestaurantsByDateEstablished(<br>&emsp; Restaurant[] r)                    | O(...)           | Description <br>`...` is ...
getRestaurantsByWarwickStars()                                                | O(...)           | Description <br>`...` is ...
getRestaurantsByRating(Restaurant[] r)                                        | O(...)           | Description <br>`...` is ...
getRestaurantsByDistanceFrom(<br>&emsp; float lat, float lon)                 | O(...)           | Description <br>`...` is ...
getRestaurantsByDistanceFrom(<br>&emsp; Restaurant[] r, float lat, float lon) | O(...)           | Description <br>`...` is ...
getRestaurantsContaining(String s)                                            | O(...)           | Description <br>`...` is ...

<div style="page-break-after: always;"></div>

## ReviewStore
### Overview
* I have used `...` to store reviews ... 
* I used `...` to sort ... 
* To get ... 
* To get top ... 

### Space Complexity
Store           | Worst Case | Description
--------------- | ---------- | -----------
ReviewStore     | O(...)     | I have used `...` ... <br>Where `...` is ...

### Time Complexity
Method                                     | Average Case     | Description
------------------------------------------ | ---------------- | -----------
addReview(Review r)                        | O(...)           | Description <br>`...` is ...
addReview(Review[] r)                      | O(...)           | Description <br>`...` is ...
getReview(Long id)                         | O(...)           | Description <br>`...` is ...
getReviews()                               | O(...)           | Description <br>`...` is ...
getReviews(Review[] r)                     | O(...)           | Description <br>`...` is ...
getReviewsByDate()                         | O(...)           | Description <br>`...` is ...
getReviewsByRating()                       | O(...)           | Description <br>`...` is ...
getReviewsByRestaurantID(Long id)          | O(...)           | Description <br>`...` is ...
getReviewsByCustomerID(Long id)            | O(...)           | Description <br>`...` is ...
getAverageCustomerReviewRating(Long id)    | O(...)           | Description <br>`...` is ...
getAverageRestaurantReviewRating(Long id)  | O(...)           | Description <br>`...` is ...
getCustomerReviewHistogramCount(Long id)   | O(...)           | Description <br>`...` is ...
getRestaurantReviewHistogramCount(Long id) | O(...)           | Description <br>`...` is ...
getTopCustomersByReviewCount()             | O(...)           | Description <br>`...` is ...
getTopRestaurantsByReviewCount()           | O(...)           | Description <br>`...` is ...
getTopRatedRestaurants()                   | O(...)           | Description <br>`...` is ...
getTopKeywordsForRestaurant(Long id)       | O(...)           | Description <br>`...` is ...
getReviewsContaining(String s)             | O(...)           | Description <br>`...` is ...

<div style="page-break-after: always;"></div>

## Util
### Overview
* **ConvertToPlace** 
    * ...
* **DataChecker**
    * ...
* **HaversineDistanceCalculator (HaversineDC)**
    * ...
* **KeywordChecker**
    * ...
* **StringFormatter**
    * ...

### Space Complexity
Util               | Worst Case | Description
-------------------| ---------- | -----------
ConvertToPlace     | O(...)     | ...
DataChecker        | O(...)     | ...
HaversineDC        | O(...)     | ... 
KeywordChecker     | O(...)     | ...
StringFormatter    | O(...)     | ...

### Time Complexity
Util              | Method                                                                             | Average Case     | Description
----------------- | ---------------------------------------------------------------------------------- | ---------------- | -----------
ConvertToPlace    | convert(float lat, float lon)                                                      | O(...)           | ... 
DataChecker       | extractTrueID(String[] repeatedID)                                                 | O(...)           | ...
DataChecker       | isValid(Long id)                                                                   | O(...)           | ...
DataChecker       | isValid(Customer customer)                                                         | O(...)           | ...
DataChecker       | isValid(Favourite favourite)                                                       | O(...)           | ...
DataChecker       | isValid(Restaurant restaurant)                                                     | O(...)           | ...
DataChecker       | isValid(Review review)                                                             | O(...)           | ...
HaversineDC       | inKilometres(<br>&emsp; float lat1, float lon1, <br>&emsp; float lat2, float lon2) | O(...)           | ...
HaversineDC       | inMiles(<br>&emsp; float lat1, float lon1, <br>&emsp; float lat2, float lon2)      | O(...)           | ...
KeywordChecker    | isAKeyword(String s)                                                               | O(...)           | ...
StringFormatter   | convertAccentsFaster(String s)                                                     | O(...)           | ...