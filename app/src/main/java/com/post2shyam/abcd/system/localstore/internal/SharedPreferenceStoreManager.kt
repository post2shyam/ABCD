package com.post2shyam.abcd.system.localstore.internal

import com.post2shyam.abcd.system.localstore.IPersistentStoreManager

class SharedPreferenceStoreManager : IPersistentStoreManager {
    override fun getRollNumber(): Int {
        return 10
    }
}