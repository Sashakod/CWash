package com.example.cwash.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.example.cwash.R;
import com.example.cwash.dto.CategoryDTO;

public class AddCategoryFragment extends DialogFragment {

   private EditText editText;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.fragment_add_category, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        final EditText editText = (EditText)view.findViewById(R.id.edit_category_name);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                CategoriesFragment categoriesFragment = (CategoriesFragment)getFragmentManager().findFragmentByTag("CATEGORIES_FRAGMENT_TAG");
                categoriesFragment.data.add(new CategoryDTO(editText.getText().toString()));
                getFragmentManager().beginTransaction().remove(categoriesFragment).replace(R.id.fragment_container, categoriesFragment).commit();
            }
        });
        return builder.create();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
