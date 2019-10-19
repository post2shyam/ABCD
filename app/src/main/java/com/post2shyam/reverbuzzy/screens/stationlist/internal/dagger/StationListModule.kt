package com.post2shyam.reverbuzzy.screens.stationlist.internal.dagger

import com.post2shyam.reverbuzzy.screens.stationlist.internal.StationListAdapter
import dagger.Module
import dagger.Provides

@Module
class StationListModule {
  @Provides
  fun providesStationListAdapter(): StationListAdapter =
    StationListAdapter()
}