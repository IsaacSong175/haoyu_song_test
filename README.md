# haoyu_song_test
## Question 1
*Your goal for this question is to write a program that accepts two lines (x1,x2) and (x3,x4) on the x-axis and returns whether they overlap. As an example, (1,5) and (2,6) overlaps but not (1,5) and (6,8).*
<br><br>
The *isOverlap* method take 4 doubles as inputs. First it will check if x1<=x2 and x3<=x4, by doing so we are limiting the first and third input as start points of two lines and other two inputs are the end points for the lines.
This assertion is used to simplify the decision process and regulate user inputs. The method returns true if overlapping and false otherwise.
## Question 2
*The goal of this question is to write a software library that accepts 2 version string as input and returns whether one is greater than, equal, or less than the other. As an example: “1.2” is greater than “1.1”. Please provide all test cases you could think of.*
<br><br>
There are a few steps involved in the comparison:
1. A regex __^\\d+(\\.\\d+)\*__ to filter the two input strings, this regex assume we only use dot to separate between major, minor, and patch. Also, the version strings can only contain positive numbers.
2. Split each string with dot and get an array of strings. We check if the lengths of two arrays are smaller or equal to 3, if not the program throws IllegalArgumentException.
3. Loop through two arrays of strings and compare each part of the two version strings.
## Question 3
The cache uses a hashtable to keep track of the keys and its values in the double linked list. Each node in the linked list also contains the modification time which is used for expiration check. It takes constant time to add and remove nodes from the head or tail since we only need to add the newest to the cache and remove the oldest from the cache.
When we try to put a new file into the cache, it will first decide whether it is already in the hashtable. If the file is new, we add it to the hashtable and remove the oldest one from hashtable. When we try to access one file from cache, we first check its modification time to see if it has been expired, if it is expired, we remove it from the hashtable and return null. Otherwise, we will return the file.
<br>
Missing functionalities:
1. Geolocation access: since the overall distribution of servers is not clear, it is hard to decide which server is the nearest to the current user. A simple solution is to store location information inside *geoDistributedLRU* class and collect location information from user to decide which cache is the closest one to user geologically.
2. Resilient to network failures or crashes: since this is only a simple design, it did not support this function. Redis could be used to include error handling and other issues that may arise in operations. Due to time limit I can not learn Redis thoroughly to offer a solution based on it.