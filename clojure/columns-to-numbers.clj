(defn position-in-alphabet [x]
  "Returns the position in the alphabet of an input character.
  Example: (position-in-alphabet \"a\") 1"
  (- 1 (- (int \A) (int (.charAt (clojure.string/upper-case x) 0)))))

(defn column-to-number [x]
  "Returns the number that represents the column of the input string. 
  In spreadsheet programs, rows are numeric but columns are strings. 
  Columns increase from \"A\" to \"Z\" to \"AA\" to \"ZZ\" to \"AAA\" and so on.
  Example: (column-to-number \"A\") 1"
  (loop [data x
        idx 0
        result 0]
    (if (empty? data)
      result
      (let [n (last data)
            pos (position-in-alphabet n)
            a (int (* (Math/pow 26 idx) pos))]
        (recur (butlast data) (inc idx) (+ a result))))))

;; simple test suite
(= 1  (column-to-number "a"))
(= 27 (column-to-number "aa"))
(= 52 (column-to-number "az"))
(= 703 (column-to-number "aaa"))
