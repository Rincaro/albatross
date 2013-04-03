package com.youdevise.albatross

import org.specs2.Specification

import Intervals._
import org.specs2.matcher.Matcher

class IntervalSetSpec extends Specification {

  def is =
  "An interval set" ^
    "orders its constituent intervals" ! {
      Interval(open(10) to open(20), open(0) to open(5)).continuousSubIntervals must_== List(open(0) to open(5), open(10) to open(20))
    } ^
    "coalesces its constituent intervals" ! {
      Interval(open(0) to open(5), open(10) to open(15), open(3) to open(12)).continuousSubIntervals must_== List(open(0) to open(15))
    } ^
    "encloses any value enclosed by any of its constituent intervals" ! {
      Interval(open(10) to open(20), open(0) to open(5)) must encloseAll(3, 15)
    } ^ end ^
  bt ^
  "The intersection of two interval sets" ^
    "contains the intersections of all sets in either interval set" ! {
      (Interval(open(0) to open(10), open(20) to open(30)) intersect
       Interval(open(5) to open(25), open(28) to open(35))).continuousSubIntervals must_== List(open(5) to open(10), open(20) to open(25), open(28) to open(30))
    } ^ end

  def encloseAll[T](values: T*)(implicit ord: Ordering[T]): Matcher[Interval[T]] = ((_: Interval[T]).enclosesAll(values), "doesn't enclose %s".format(values))

}
