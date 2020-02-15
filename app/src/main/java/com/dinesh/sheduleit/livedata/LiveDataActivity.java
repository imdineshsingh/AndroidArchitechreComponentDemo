package com.dinesh.sheduleit.livedata;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.dinesh.sheduleit.R;
import com.dinesh.sheduleit.databinding.ActivityLiveDataBinding;

public class LiveDataActivity extends AppCompatActivity {

    private ActivityLiveDataBinding binding;
    private LiveDataViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_live_data);

        viewModel= new  ViewModelProvider(this).get(LiveDataViewModel.class);

        LiveData<String> myRandomNumber=viewModel.getNumber();
        myRandomNumber.observe(this, new Observer<String>() {          //attach observer object to the Livedata using the Observe method
            @Override
            public void onChanged(String s) {  //inside on change method we ll update ui when data gets changed
                binding.myTv.setText(s);
            }
        });

        binding.btnGenerateNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.generateNumber();   //we are changeing or generating new Random number on buttom click so that it(Data) could be observed by LiveData
            }
        });


        initViewMore();
    }
    void initViewMore(){
        //binding.textView.setText(discription);
        binding.textView.setText("The quick br ");
        if (binding.textView.getText().length()>30) {
            makeTextViewResizable(binding.textView, 2, "See More", true);
        }

    }

    public  void makeTextViewResizable(final TextView tv, final int maxLine, final String expandText, final boolean viewMore) {

            if (tv.getTag() == null) {
                tv.setTag(tv.getText());
            }
            ViewTreeObserver vto = tv.getViewTreeObserver();
            vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

                @SuppressWarnings("deprecation")
                @Override
                public void onGlobalLayout() {

                    ViewTreeObserver obs = tv.getViewTreeObserver();
                    obs.removeGlobalOnLayoutListener(this);
                    if (maxLine == 0) {
                        int lineEndIndex = tv.getLayout().getLineEnd(0);
                        String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                        tv.setText(text);
                        tv.setMovementMethod(LinkMovementMethod.getInstance());
                        tv.setText(
                                addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                        viewMore), TextView.BufferType.SPANNABLE);
                    } else if (maxLine > 0 && tv.getLineCount() >= maxLine) {
                        int lineEndIndex = tv.getLayout().getLineEnd(maxLine - 1);
                        String text = tv.getText().subSequence(0, lineEndIndex - expandText.length() + 1) + " " + expandText;
                        tv.setText(text);
                        tv.setMovementMethod(LinkMovementMethod.getInstance());
                        tv.setText(
                                addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, maxLine, expandText,
                                        viewMore), TextView.BufferType.SPANNABLE);
                    } else {
                        int lineEndIndex = tv.getLayout().getLineEnd(tv.getLayout().getLineCount() - 1);
                        String text = tv.getText().subSequence(0, lineEndIndex) + " " + expandText;
                        tv.setText(text);
                        tv.setMovementMethod(LinkMovementMethod.getInstance());
                        tv.setText(
                                addClickablePartTextViewResizable(Html.fromHtml(tv.getText().toString()), tv, lineEndIndex, expandText,
                                        viewMore), TextView.BufferType.SPANNABLE);
                    }
                }
            });

        }

        private  SpannableStringBuilder addClickablePartTextViewResizable(final Spanned strSpanned, final TextView tv,
                                                                                final int maxLine, final String spanableText, final boolean viewMore) {
            String str = strSpanned.toString();
            SpannableStringBuilder ssb = new SpannableStringBuilder(strSpanned);

            if (str.contains(spanableText)) {


                ssb.setSpan(new MySpannable(false){
                    @Override
                    public void onClick(View widget) {
                        if (viewMore) {
                            tv.setLayoutParams(tv.getLayoutParams());
                            tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                            tv.invalidate();
                            makeTextViewResizable(tv, -1, "See Less", false);
                        } else {
                            tv.setLayoutParams(tv.getLayoutParams());
                            tv.setText(tv.getTag().toString(), TextView.BufferType.SPANNABLE);
                            tv.invalidate();
                            makeTextViewResizable(tv, 3, ".. See More", true);
                        }
                    }
                }, str.indexOf(spanableText), str.indexOf(spanableText) + spanableText.length(), 0);

            }
            return ssb;

        }

    public class MySpannable extends ClickableSpan {
        private boolean isUnderline = true;

        /**
         * Constructor
         */
        public MySpannable(boolean isUnderline) {
            this.isUnderline = isUnderline;
        }

        @Override
        public void updateDrawState(TextPaint ds) {
            ds.setUnderlineText(isUnderline);
            ds.setColor(Color.parseColor("#1b76d3"));
        }

        @Override
        public void onClick(View widget) {
        }
    }



}
