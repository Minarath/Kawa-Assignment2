package com.kawa.kaeaassignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.kawa.kaeaassignment.databinding.ActivityMainBinding;
import com.kawa.kaeaassignment.databinding.CellColumBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    View view;
    ArrayList<CellColumBinding> viewList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        //generate random number and bind
        viewList.add(inflateFirstColumns(10, 0));
        viewList.add(inflateFirstColumns(20, 11));
        viewList.add(inflateFirstColumns(30, 21));
        viewList.add(inflateFirstColumns(40, 31));
        viewList.add(inflateFirstColumns(50, 41));
        viewList.add(inflateFirstColumns(60, 51));
        viewList.add(inflateFirstColumns(70, 61));
        viewList.add(inflateFirstColumns(80, 71));
        viewList.add(inflateFirstColumns(90, 81));


        //row must have only 5 numbers
        for (int i = 1; i < 4; i++) {
            int randomIndex = getRandomNumber(8, 0);
            int randomTextIndex = getRandomNumber(3, 1);
            CellColumBinding columBinding = viewList.get(randomIndex);

            if (randomTextIndex == 1) {
                columBinding.txtOne.setText("");
            } else if (randomTextIndex == 2) {
                columBinding.txtTwo.setText("");
            } else if (randomTextIndex == 3) {
                columBinding.txtThree.setText("");
            }
        }

    }

    private CellColumBinding inflateFirstColumns(int max, int min) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(getRandomNumber(max, min));
        numbers.add(getRandomNumber(max, min));
        numbers.add(getRandomNumber(max, min));
        Collections.sort(numbers);

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        CellColumBinding columBinding = DataBindingUtil.inflate(inflater, R.layout.cell_colum, null, false);

        columBinding.txtOne.setText("" + checkZero(numbers.get(0)));
        columBinding.txtTwo.setText("" + checkZero(numbers.get(1)));
        columBinding.txtThree.setText("" + checkZero(numbers.get(2)));
        view = columBinding.getRoot();
        binding.lenMainHolder.addView(view);
        return columBinding;
    }

    private int getRandomNumber(int max, int min) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    private String checkZero(int n) {
        if (n == 0)
            return "";
        else
            return "" + n;
    }


}