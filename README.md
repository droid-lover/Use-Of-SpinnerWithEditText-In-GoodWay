# Use-Of-SpinnerWithEditText-In-GoodWay
Use Of SpinnerWithEditText In GoodWay - by Sachin Rajput


If you are having Spinner and EditText on an activity then this is the problem you are gonna feel for sure ,

call onTouchListener on your spinner and inside that take the reference of your edittext and hide softkeyboard.

 mySpinner.setOnTouchListener(new View.OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            InputMethodManager inputMethodManager=(InputMethodManager)getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(mReuestBloodActNotes.getWindowToken(), 0);
            return false;
        }
    }) ;





Thanks Happy COidng:) 
