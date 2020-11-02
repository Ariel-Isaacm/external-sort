# External-sort

Hi All 👋 

This is my take on an improvised external sort. 

This has a couple of assumptions:

1. Each run of this program contemplates a non changing state between files.

2. No new files are to be expected to be processed between runs.  

I didn't have the time to actually measure the sizes of the objects to make sure this solution scales well with a lot of files.

The overall complexity of this approach is   
O( n*s + log(n)) where n = number of files and s = number of lines of the biggest file. Since I'm using a priority queue insertion time is log(n).