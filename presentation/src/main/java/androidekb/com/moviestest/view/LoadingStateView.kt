package androidekb.com.moviestest.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import androidekb.com.moviestest.R
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.view_loading_state.view.*


class LoadingStateView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    FrameLayout(context, attrs, defStyleAttr) {

    private var onRefreshListener: (() -> Unit)? = null

    init {
        inflate(context, R.layout.view_loading_state, this)

        val attributes =
            context.obtainStyledAttributes(attrs, R.styleable.LoadingStateView, defStyleAttr, 0)

        setErrorText(attributes.getString(R.styleable.LoadingStateView_textError))
        errorLayout.isVisible =
            attributes.getBoolean(R.styleable.LoadingStateView_errorVisibility, false)
        progressBarLayout.isVisible =
            attributes.getBoolean(R.styleable.LoadingStateView_progressVisibility, false)

        attributes.recycle()

        retryButton.setOnClickListener { onRefreshListener?.invoke() }

        if (isInEditMode) showLoadingState()
    }

    fun setOnRefreshListener(onRefreshListener: (() -> Unit)?) {
        this.onRefreshListener = onRefreshListener
    }

    @Suppress("unused")
    fun setErrorText(@StringRes errorText: Int) {
        errorTextView.setText(errorText)
    }
    @Suppress("unused")
    fun setErrorText(textNoContent: String?) {
        errorTextView.text = textNoContent
    }

    fun showLoadingState() {
        errorLayout.isVisible = false
        progressBarLayout.isVisible = true
    }

    fun showErrorState() {
        errorLayout.isVisible = true
        progressBarLayout.isVisible = false
    }

    fun showLoadedState() {
        errorLayout.isVisible = false
        progressBarLayout.isVisible = false
    }
}