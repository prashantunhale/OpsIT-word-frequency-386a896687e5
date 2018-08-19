# Word Frequency

## The brief
Write a solution that counts the number of occurrences of words in given Strings. The number of occurrences of each word should be stored in a HashMap. For example if the String `the man in the moon` is passed in then the HashMap will contain:  
         
        “the”:	2  
        “man”:	1  
        “in”:	1     
        “moon”:	1

If subsequently the String `the man on the moon` is passed in then the Map will now contain:  

        “the”:	4
        “man”:	2
        “in”:	1
        “on”:	1
        “moon”:	2


## Detailed Requirements
You can assume input consists of only ASCII code points

The solution should
* reject if the input is empty, null
* ignore any characters which is non-printable (any control/whitespace/) or punctuation
* be thread-safe so that occurrences are correctly updated when concurrently invoked.
* handle exception / error condition gracefuly
* re-usable in different context (used by a Thick Client, or wrapped as a RESTful Web Service)

The submission is expected to be *Production Quality* which means it is
* highly readable,
* with quality and testable design,
* plus appropriate test coverage

You are not expected to use any external library except below:
* JDK
* JUnit
* Mockito
* Log4j
* slf4j


## The submission
To complete the exercise, provide the implementation with appropriate automated tests

The submission should not include any binary or generated files. 

The Gradle build script will be used for running build and test
