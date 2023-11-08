# A7
I am very happy to report that after some struggle, I had yet another successful week of Data Structures!! In all honesty, I was pretty confused by the actual implementation of the sort methods when I began this assignment. The instructions made sense in theory but I ended up staring at blank code for long periods of time trying to figure out where to start. Once I got a little help, I felt more confident in the skills we learned this week. Despite the fact that two brackets that needed to be moved a few lines over made me cry after stressing over why the graphics wouldn't run, I eventually felt content and confident in my abilities. For the timer experiment, my computer decided that 9000 cards was perfectly fine, but 10000 was just too much to handle. Working with what my computer was able to work with I found that at the higher card counts, Merge Sort was the fastest while Selection Sort was the slowest. I think this could be due to the fact that Selection Sort has to search the whole unsorted pile to find the lowest card, while Merge Sort divides and conquers.  


Timer Experiment:
(Key: 🐢 = slowest for that card count, 🐇 = fastest for that card count)
---------------------
1000
Selection: 
real    0m0.209s
user    0m0.220s 🐇
sys     0m0.048s

Merge:
real    0m0.197s
user    0m0.230s
sys     0m0.044s

Insertion:
real    0m0.211s
user    0m0.237s 🐢
sys     0m0.045s
---------------------
2000
Selection:
real    0m0.239s
user    0m0.404s
sys     0m0.048s

Merge:
real    0m0.235s
user    0m0.463s 🐢
sys     0m0.050s

Insertion:
real    0m0.225s
user    0m0.396s 🐇
sys     0m0.044s
---------------------
5000
Selection:
real    0m0.668s
user    0m1.416s 🐇
sys     0m0.131s

Merge:
real    0m0.611s
user    0m1.709s
sys     0m0.148s

Insertion:
real    0m0.569s
user    0m1.763s 🐢
sys     0m0.138s
---------------------
7000:
Selection:
real    0m2.721s
user    0m5.587s 🐢
sys     0m0.822s

Merge:
real    0m1.530s
user    0m5.244s 🐇
sys     0m0.277s

Insertion:
real    0m1.511s
user    0m5.304s
sys     0m0.254s
---------------------
9000
Selection:
real    0m2.710s
user    0m8.701s 🐢
sys     0m0.672s

Merge:
real    0m2.281s
user    0m8.127s 🐇
sys     0m0.653s

Insertion:
real    0m2.619s
user    0m8.609s
sys     0m0.643s