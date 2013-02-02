; Add all the natural numbers below one thousand that are multiples of 3 or 5.
(reduce + 
  (filter #(or (= (rem % 5) 0)(= (rem % 3) 0)) 
    (range 0 1000)))
; 233168
