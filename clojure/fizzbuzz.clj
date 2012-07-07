; fizzbuzz in Clojure
(defn fizzbuzz 
  ([] (fizzbuzz 100))
  ([n] 
  (map 
    #(if (= (rem % 15) 0) 
      "fizzbuzz" 
      (if (= (rem % 3) 0) 
        "fizz" 
        (if (= (rem % 5) 0) 
          "buzz" 
          %)))
  (range 1 n))))

(fizzbuzz)
(fizzbuzz 100)
