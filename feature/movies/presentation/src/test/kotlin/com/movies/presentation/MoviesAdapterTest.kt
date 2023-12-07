package com.movies.presentation

import android.content.Context
import android.widget.FrameLayout
import com.movies.presentation.model.MoviesView
import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class MoviesAdapterTest {

    private lateinit var context: Context

    @Before
    fun setup() {
        context = RuntimeEnvironment.getApplication()
    }

    private val items = listOf(
        MoviesView(
            title = "title",
            date = "1930",
            imageUrl = "https://example.com",
            description = "description",
        ),
    )
    private val adapter = MoviesAdapter(items) {}

    @Test
    fun onCreateViewHolder() {
        val holder = adapter.createViewHolder(FrameLayout(context), 0)
        Assert.assertTrue(holder is MovieViewHolder)
    }

    @Test
    fun getItemCount() {
        assertEquals(1, adapter.itemCount)
    }

    @Test
    fun onBindViewHolder() {
        val holder = adapter.createViewHolder(FrameLayout(context), 0)
        val view = (holder as MovieViewHolder).binding
        adapter.onBindViewHolder(holder, 0)
        assertEquals(view.titleTv.text, items[0].title)
        assertEquals(view.dateTv.text, items[0].date)
        assertEquals(
            true,
            view.root.hasOnClickListeners()
        )
    }
}
