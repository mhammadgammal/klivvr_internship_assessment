package com.support.klivvrinternshipassessment

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.support.klivvrinternshipassessment.core.helper.parseJsonToList
import com.support.klivvrinternshipassessment.core.utils.mergeSort
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.support.klivvrinternshipassessment", appContext.packageName)
    }


    @Test
    fun testMergeSort() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        val jsonInputStream = appContext.assets.open("cities[486].json")
        val parsedList = parseJsonToList(jsonInputStream)
        assertEquals(
            mergeSort(parsedList),
            parsedList.sortedBy { it.name }
        )
    }
}
