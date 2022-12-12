(ns test-deps.test-deps
  (:require [clojure.java.io :as io]
            [clojure.tools.namespace.find :as find]))

(defn- require-namespaces-in-dir
  "Scan namespaces in a dir and require them."
  [dir]
  (for [ns (find/find-namespaces-in-dir dir)]
    (do
      (require ns)
      (find-ns ns))))

(defn require-test-namespaces
 ""
 []
 (require-namespaces-in-dir (io/file "test")))


(require-test-namespaces)

