(defn fib [n] 
  (take n 
    (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1]))))

(last (fib 35))
; 5702887

(filter #(> % 4000000)(fib 35))

(reduce +  (filter even? (fib3 35)))
; 4613732

(reduce + (filter even? (filter #(< % 4000000)(fib3 35))))
