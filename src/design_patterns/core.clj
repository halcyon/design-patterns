(ns design-patterns.core)

(sort (comparator
       (fn [u1 u2]
         (cond
          (= (:subscription u1)
             (:subscription u2)) (compare (:name u1)
                                          (:name u2))
             (:subscription u1) true
             :else false))) [{:subscription true
                              :name "ted"}
                             {:name "jack"}
                             {:name "bill"}
                             {:name "alvin"}
                             {:subscription true
                              :name "alan"}])

(reduce conj {} (map (juxt :id identity) [{:id 1 :name "foo"}
                                          {:id 2 :name "bar"}
                                          {:id 3 :name "baz"}]))


(sort-by (juxt (complement :subscription) :name) [{:subscription true
                                                   :name "ted"}
                                                  {:name "jack"}
                                                  {:name "bill"}
                                                  {:name "alvin"}
                                                  {:subscription true
                                                   :name "alan"}])

((juxt (complement :subscription) :name) {:subscription true
                                          :name "ted"})

((juxt (complement :subscription) :name) {:name "bill"})
