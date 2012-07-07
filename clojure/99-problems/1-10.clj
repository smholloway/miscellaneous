;; Adapted from Scala 99 problems
;; http://aperiodic.net/phil/scala/s-99/

; Problem 1 - Find the last element of a list.
(defn p1 [l] 
  (last l))

; Problem 2 - Find the last but one element of a list.
(defn p2 [l] 
  (last (take (dec (count l)) l)))
(defn p2-2 [l]
  (last (butlast l)))

; Problem 3 - Find the Kth element of a list.
(defn p3 [l k] 
  (nth l k))

; Problem 4 - Find the number of elements of a list.
(defn p4 [l] 
  (count l))

; Problem 5 - Reverse a list.
(defn p5 [l] 
  (reverse l))

; Problem 6 - Find out whether a list is a palindrome.
(defn p6 [l] 
  (= (l (reverse l)))

; Problem 7 - Flatten a nested list structure.
(defn p7 [l] 
  (flatten l))

; Problem 8 - Eliminate consecutive duplicates of list elements.
###TODO
(defn p8 [l] 
  (l))

; Problem 9 - Pack consecutive duplicates of list elements into sublists.
###TODO
(defn p9 [l]
  (l))

; Problem 10 - Run-length encoding of a list.
###TODO
(defn p10 [l]
  (l))


; Define sample data
(def l [0 1 2 3 4 5 6 7 8 9] )
(def k 5)


; Execute each problem
(p1 l)
(p2 l)
(p3 l k)
(p4 l)
(p5 l)
(p6 l)
(p7 l)
(p8 l)
(p9 l)
(p10 l)

