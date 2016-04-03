package com.example.toshiba.appenglish.lessPre;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.toshiba.appenglish.Fragment2_lesson;
import com.example.toshiba.appenglish.R;

//import android.support.v4.app.FragmentManager;

/*
 * Created by Toshiba on 5/1/2559.
 */
public class Fragment2_lessPre extends Fragment implements View.OnClickListener {
    View rootview;
    Button butback, butSim, butCon, butPer, butPerCon;
    ViewPager viewPager;
    ImageView imageView;
    WebView webView;

    int a, b, c = 0;

    //String[] mPre;
    private ListView mlistView;

    //public static final String KEY_DRAWABLE_ID = "drawableId";


/*
    private int[] imageResourceIds = {
            R.drawable.testpic2,
            R.drawable.tespic1
    };
*/


    //private Integer images[] = {R.drawable.testpic2};
    //private Drawable[] drawables = null;
    //Drawable drawable,drawable1 = null;
    //int[] images = {R.drawable.tespic1,R.drawable.testpic2,R.drawable.bb};

//    private Integer[] mImageIds = {
//            R.drawable.a1,
//            R.drawable.a21,
//            R.drawable.a22,
//            R.drawable.a3,
//            R.drawable.aaa
//    };


    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.layout2_lesson_present, container, false);

        //imageView = (ImageView) rootview.findViewById(R.id.imageLess1);

        //webView = (WebView) rootview.findViewById(R.id.webview);

        //drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.kkk, null);

        /*drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.tespic1, null);
        drawable1 = ResourcesCompat.getDrawable(getResources(), R.drawable.testpic2, null);*/

/*        Context mContext = getActivity();
        drawable = ContextCompat.getDrawable(mContext, page.getImageId());
        drawable = mContext.getResources().getDrawable(R.drawable.tespic1);
        drawable1 = mContext.getResources().getDrawable(R.drawable.testpic2);*/

/*
        mPre=getResources().getStringArray(R.array.drawer_presim);
        mlistView = (ListView) rootview.findViewById(R.id.drawer);
        mlistView.setAdapter(new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,mPre));
*/

/*        mlistView = (ListView) rootview.findViewById(R.id.drawer);
        mlistView.setAdapter(new ImageAdapter(getActivity()));*/
        a = 1;


        butback = (Button) rootview.findViewById(R.id.button_back);
        butSim = (Button) rootview.findViewById(R.id.but_lessPre1);
        butCon = (Button) rootview.findViewById(R.id.but_lessPre2);
        butPer = (Button) rootview.findViewById(R.id.but_lessPre3);
        butPerCon = (Button) rootview.findViewById(R.id.but_lessPre4);

        butback.setOnClickListener(this);
        butSim.setOnClickListener(this);
        butCon.setOnClickListener(this);
        butPer.setOnClickListener(this);
        butPerCon.setOnClickListener(this);


        /*Bundle bundle = getArguments();
        if (bundle != null)
        {
            int imageID = bundle.getInt(Imagekey);


            setValues(rootview , imageID);
        }*/

/*        Bundle bundle = getArguments();
        if (bundle != null)
        {
            int imageID = bundle.putInt(KEY_DRAWABLE_ID, imageResourceIds[imageID]);

            setValues(imageID);
        }*/


        return rootview;
    }


/*    private void setValues(int imageID) {

        ImageView imageView = (ImageView) rootview.findViewById(R.id.imageLess);
        imageView.setImageResource(imageID);
    }*/



/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewPager = (ViewPager) rootview.findViewById(R.id.pager);

        List<Fragment> listFragment = new ArrayList<Fragment>();
        listFragment.add(new Fragment2_lessonPre_page1());
        listFragment.add(new Fragment2_lessonPre_page2());
        listFragment.add(new Fragment2_lessonPre_page3());
        listFragment.add(new Fragment2_lessonPre_page4());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(
                getFragmentManager(), listFragment);

    }*/

/*    private void setImageView(int image){
        imageView = (ImageView) rootview.findViewById(R.id.imageLess1);
        imageView.setImageResource(image);
    }*/

    @Override
    public void onClick(View v) {
        //ImageView imageView = (ImageView) rootview.findViewById(R.id.imageLess);

        if (v.getId() == R.id.button_back) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lesson()).commit();
        } else if (v.getId() == R.id.but_lessPre1) {
            FragmentManager fm = getFragmentManager();
            fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page1()).commit();
            Toast.makeText(getActivity(), " Lesson Present Simple Tense was selected. ", Toast.LENGTH_LONG).show();


            //Bitmap bMap = BitmapFactory.decodeResource(getResources(), R.drawable.a1);
            //imageView.setImageResource(mImageIds[0]);


            //imageView.setImageDrawable(drawable);


            //drawable = ContextCompat.getDrawable(getActivity(), R.drawable.kkk);
            //imageView.setImageDrawable(drawable);


            //imageView.setImageResource(R.drawable.testpic2);

            //ImageView imageView = (ImageView) rootview.findViewById(R.id.imageLess);
            //imageView.setImageResource(R.drawable.testpic2);

            //setValues(R.drawable.testpic2);
            //imageView.setImageResource(R.drawable.testpic2);
            /*Intent i = new Intent(getActivity(),MainSwipe.class);
            startActivity(i);*/

        }
        /*else if (v.getId()==R.id.but_lessPre2){
            Intent i = new Intent(getActivity(),MainSwipe.class);
            startActivity(i);
            Toast.makeText(getActivity(), " Lesson Present Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if (v.getId()==R.id.but_lessPre3){
            Intent i = new Intent(getActivity(),MainSwipe.class);
            startActivity(i);
            Toast.makeText(getActivity(), " Lesson Present Perfect Tense was selected. ", Toast.LENGTH_LONG).show();
        }
        else if (v.getId()==R.id.but_lessPre4){
            Intent i = new Intent(getActivity(),MainSwipe.class);
            startActivity(i);
            Toast.makeText(getActivity(), " Lesson Present Perfect Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
        }*/


        else if (v.getId() == R.id.but_lessPre2) {
            if (a == 2) {
                butCon.setClickable(true);
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page2()).commit();

                Toast.makeText(getActivity(), " Lesson Present Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butCon.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Present simple tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.but_lessPre3) {
            if (a == 3) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page3()).commit();
                Toast.makeText(getActivity(), " Lesson Present Perfect Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butPer.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Present continuous tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        } else if (v.getId() == R.id.but_lessPre4) {
            if (a == 4) {
                FragmentManager fm = getFragmentManager();
                fm.beginTransaction().replace(R.id.maincontent, new Fragment2_lessonPre_page4()).commit();
                Toast.makeText(getActivity(), " Lesson Present Perfect Continuous Tense was selected. ", Toast.LENGTH_LONG).show();
            } else {
                butPerCon.setClickable(false);
                Toast.makeText(getActivity(), " ต้องผ่านแบบทดสอบ Present Perfect tense ก่อน ", Toast.LENGTH_LONG).show();
            }
        }

    }

/*    public class ImageAdapter extends BaseAdapter {
        private Context mContext;

        private Integer[] mImageIds = {
                R.drawable.a1,
                R.drawable.a21,
                R.drawable.a22,
                R.drawable.a3
        };


        public ImageAdapter(Context c) {
            mContext = c;
        }

        public int getCount() {
            return mImageIds.length;
        }

        public Object getItem(int position) {
            return position;
        }

        public long getItemId(int position) {
            return position;
        }

        public View getView(int arg0, View arg1, ViewGroup arg2) {
// TODO Auto-generated method stub
            ImageView i = new ImageView(mContext);
            i.setImageResource(mImageIds[arg0]);
            return i;
        }
    }*/

//    private void finish() {
//        finish();
//    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.layout2_lesson_present);
//
//    }


    //========================== Not use
//    public void replaceFragment() {
//
//        Fragment objFragment = null;
//////        FragmentManager fm = getFragmentManager();
//////        fm.beginTransaction().replace(R.id.maincontent, objFragment).commit();
////
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        transaction.replace(R.id.maincontent, objFragment);
//        transaction.commit();
//
//   }

//    public void replaceFragment() {
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.maincontent, objFragment);
//        transaction.commit();
//    }


/*    public static class FragmentosImagenes extends Fragment {

        private static final String ARG_IMAGE = "imagen";
        private int imagen;

        public static FragmentosImagenes newInstance(int imagen) {
            FragmentosImagenes fragment = new FragmentosImagenes();
            Bundle args = new Bundle();
            args.putInt(ARG_IMAGE, imagen);
            fragment.setArguments(args);
            fragment.setRetainInstance(true);
            return fragment;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if(getArguments() != null) {
                imagen = getArguments().getInt(ARG_IMAGE);
            }
        }

        public FragmentosImagenes() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.layout2_lesson_present, container, false);

            ImageView imagenView = (ImageView) rootView.findViewById(R.id.imageLess);
            imagenView.setImageResource(imagen);
            return rootView;
        }
    }*/
}
