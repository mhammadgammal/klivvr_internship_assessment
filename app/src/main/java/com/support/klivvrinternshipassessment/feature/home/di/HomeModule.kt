package com.support.klivvrinternshipassessment.feature.home.di

import android.content.Context
import com.support.klivvrinternshipassessment.feature.home.data.repository.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object HomeModule {

    @Provides
    fun provideContext(@ApplicationContext context: Context): Context = context

    @Provides
    fun provideHomeRepository(@ApplicationContext context: Context): HomeRepository =
        HomeRepository(context)

}
