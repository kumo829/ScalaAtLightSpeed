package com.tutorials.scala.lightspeed.functions

object PartiallyAppliedFunctions extends App {
  val googlStockPrices = List(1367.36, 1360.66, 1394.20, 1393.33, 1404.31, 1419.82, 1429.73)

  def checkPriceGreaterThan1400(price: Double): Boolean = price > 1400

  var pricesGreaterThan1400 = googlStockPrices.filter(price => price > 1400)

  println(pricesGreaterThan1400)


  /*
  _ is a placeholder for an entire parameter list. This is a partially applied function, where you dont supply all of the
  arguments the function needs, you specify either some or none of the arguments
   */
  //  println(googlStockPrices.filter(checkPriceGreaterThan1400 _))
  println(googlStockPrices.filter(checkPriceGreaterThan1400))

  def checkPriceInRange(price: Double, lower: Double, upper: Double): Boolean = price >= lower && price <= upper

  val googlStockPricesInRangeFunction1 = checkPriceInRange _
  val googlStockPricesInRangeFunction2 = checkPriceInRange(_: Double, _: Double, upper = 1410)
  val googlStockPricesInRangeFunction3 = checkPriceInRange(_: Double, lower = 1390, upper = 1410)

  var pricesInRange1 = googlStockPrices.filter(price => googlStockPricesInRangeFunction1(price, 1390, 1410))
  var pricesInRange2 = googlStockPrices.filter(price => googlStockPricesInRangeFunction2(price, 1390))
  var pricesInRange3 = googlStockPrices.filter(googlStockPricesInRangeFunction3)

  println(pricesInRange1)
  println(pricesInRange2)
  println(pricesInRange3)
}
