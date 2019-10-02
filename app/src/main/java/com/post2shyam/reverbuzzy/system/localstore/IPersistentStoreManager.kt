package com.post2shyam.reverbuzzy.system.localstore

interface IPersistentStoreManager {
  fun getRollNumber(): Int
  fun setRollNumber(rollNumber: Int)
}