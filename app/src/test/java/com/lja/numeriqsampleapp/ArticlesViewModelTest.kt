package com.lja.numeriqsampleapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.lja.numeriqsampleapp.service.model.shared.ArticleShared
import com.lja.numeriqsampleapp.usecases.GetListArticlesUseCase
import com.lja.numeriqsampleapp.viewmodel.ArticlesViewModel
import com.lja.numeriqsampleapp.viewmodel.State
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class ArticlesViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var mockObserver: Observer<State<List<ArticleShared>>>

    @InjectMocks
    private lateinit var myViewModel: ArticlesViewModel

    @Mock
    private lateinit var useCase: GetListArticlesUseCase

    @Mock
    private lateinit var resultList: List<Nothing>


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onOptionsSelected() {
        testCoroutineRule.runBlockingTest {
            val flow = flow {
                emit(resultList)
            }

            given(useCase.execute("", "", "", "")).willReturn(
                flow
            )

            then(mockObserver).should().onChanged(State.Success(resultList))
        }
    }
}