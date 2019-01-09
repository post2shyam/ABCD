package com.post2shyam.abcd.system.localstore

interface IPersistentStoreManager {
  fun getRollNumber(): Int
  fun setRollNumber(rollNumber: Int)
}