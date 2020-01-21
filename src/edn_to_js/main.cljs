(ns edn-to-js.main
  (:require [cljs.nodejs :as nodejs]
            [cljs.reader :as r]))

(defn edn->js [edn]
  (clj->js (r/read-string edn)))

