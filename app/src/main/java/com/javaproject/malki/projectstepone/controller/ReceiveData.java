package com.javaproject.malki.projectstepone.controller;

import android.app.Activity;
import android.graphics.ColorSpace;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.javaproject.malki.projectstepone.R;
import com.javaproject.malki.projectstepone.model.DataSource.List_DB;
import com.javaproject.malki.projectstepone.model.backend.DbManagerFactory;
import com.javaproject.malki.projectstepone.model.entities.Branch;
import com.javaproject.malki.projectstepone.model.entities.Car;
import com.javaproject.malki.projectstepone.model.entities.CarModel;
import com.javaproject.malki.projectstepone.model.entities.Client;
import com.javaproject.malki.projectstepone.model.entities.Order;

import java.util.ArrayList;
import java.util.List;

/* 3.2 receive car/ model or user
 according to specific terms*/
public class ReceiveData extends Activity implements View.OnClickListener{
    private AutoCompleteTextView searchBanner;
    private CheckBox isCar;
    private CheckBox isModel;
    private CheckBox isUser;
    private CheckBox isBranch;
    private CheckBox isOrder;
    private CheckBox currentChoose;
    private Button searchButton;
    private ScrollView scrollResults;
    //private TextView result;

    private void findViews()
    {
        searchBanner = (AutoCompleteTextView) findViewById(R.id.searchItems);
        isCar = (CheckBox) findViewById(R.id.checkbox_car);
        isModel = (CheckBox) findViewById(R.id.checkbox_model);
        isUser = (CheckBox) findViewById(R.id.checkbox_user);
        isBranch = (CheckBox) findViewById(R.id.checkbox_branch);
        isOrder = (CheckBox) findViewById(R.id.checkbox_order);
        searchButton = (Button) findViewById(R.id.searchButton);
        scrollResults = (ScrollView) findViewById(R.id.scrollResults);
        //result = () findViewById(R.id.result);

        searchButton.setOnClickListener(this);

    }
    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        int ids[] = {R.id.checkbox_car,R.id.checkbox_model, R.id.checkbox_user,R.id.checkbox_branch,R.id.checkbox_order};
        boolean checked = ((CheckBox) view).isChecked();
        if(checked)
        {
            currentChoose = (CheckBox) findViewById(view.getId());
            for(int i = 0; i < ids.length; i++)
            {

                if (ids[i] != view.getId() && checked )
                {
                    //if one checkBox was chosen the other checkboxes are not available
                    ((CheckBox)findViewById(ids[i])).setEnabled(false);
                }
            }
        }else
        {
            //nothing had chose
            currentChoose = null;
            //if unchecked all return to be available

            for(int i = 0; i < ids.length; i++)
            {
                //if one checkBox was chosen the other checkboxes are not available
                ((CheckBox)findViewById(ids[i])).setEnabled(true);
            }
        }

    }
    @Override
    public void onClick(View view) {
        if(view == searchButton)
        {
            SearchFunction(currentChoose);
        }
    }

    private void SearchFunction(CheckBox view) {
        // Is the view now checked?
        boolean checked = view.isChecked();
        final String terms = searchBanner.getText().toString();

        try
        {
            if ( checked)
            {
                switch(view.getId()) {
                    case R.id.checkbox_car:
                        new AsyncTask<Void, Void, ListAdapter>() {
                            @Override
                            protected ListAdapter doInBackground(Void... params) {
                                List<Car> results = SearchCar(terms);
                                return new ArrayAdapter<Car>(getBaseContext(), R.layout.result_presentation, results);     }
                            @Override
                            protected void onPostExecute(ListAdapter adapter) {
                                //setListAdapter(adapter);//// TODO: 21-Dec-17 adapter and asynctask
                            } }.execute();
                        SearchCar(terms);
                        break;
                    case R.id.checkbox_model:
                        SearchCarModel(terms);
                        break;
                    case R.id.checkbox_user:
                        SearchClient(terms);
                        break;
                    case R.id.checkbox_branch:
                        SearchBranch(terms);
                        break;
                    case R.id.checkbox_order:
                        SearchOrder(terms);
                        break;
                }
            }
            else
            {
                throw new Exception("Select specific field to search");
            }
        }catch (Exception e)
        {
            Toast toast = Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG );
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
            toast.show();
        }
    }

    private List<Car> SearchCar(String searchTerm)
    {
        List<Car> results = new ArrayList<Car>();
        List<Car> cars = DbManagerFactory.getManager().GetCars();
        if(searchTerm.equals(""))
        {
            return cars;
        }
        String terms[] = searchTerm.trim().contains(" ")? searchTerm.split(" "): new String[]{searchTerm};
        for(Car c : cars)
        {
            for(String s: terms)
            {
                if(c.toString().contains(s))
                {
                    results.add(c);
                    break;
                }
            }
        }
        return results;
    }
    private List<CarModel> SearchCarModel(String searchTerm)
    {
        List<CarModel> results = new ArrayList<CarModel>();
        List<CarModel> carModels = DbManagerFactory.getManager().GetModels();
        if(searchTerm.equals(""))
        {
            return carModels;
        }
        String terms[] = searchTerm.trim().contains(" ")? searchTerm.split(" "): new String[]{searchTerm};
        for(CarModel c : carModels)
        {
            for(String s: terms)
            {
                if(c.toString().contains(s))
                {
                    results.add(c);
                    break;
                }
            }
        }
        return results;
    }
    private List<Client> SearchClient(String searchTerm)
    {
        List<Client> results = new ArrayList<Client>();
        List<Client> Clients = DbManagerFactory.getManager().GetClients();
        if(searchTerm.equals(""))
        {
            return Clients;
        }
        String terms[] = searchTerm.trim().contains(" ")? searchTerm.split(" "): new String[]{searchTerm};
        for(Client c : Clients)
        {
            for(String s: terms)
            {
                if(c.toString().contains(s))
                {
                    results.add(c);
                    break;
                }
            }
        }
        return results;
    }
    private List<Branch> SearchBranch(String searchTerm)
    {
        List<Branch> results = new ArrayList<Branch>();
        List<Branch> Branchs = DbManagerFactory.getManager().GetBranches();
        if(searchTerm.equals(""))
        {
            return Branchs;
        }
        String terms[] = searchTerm.trim().contains(" ")? searchTerm.split(" "): new String[]{searchTerm};
        for(Branch c : Branchs)
        {
            for(String s: terms)
            {
                if(c.toString().contains(s))
                {
                    results.add(c);
                    break;
                }
            }
        }
        return results;
    }
    private List<Order> SearchOrder(String searchTerm)
    {
        List<Order> results = new ArrayList<Order>();
        List<Order> Orders = DbManagerFactory.getManager().GetOrders();
        if(searchTerm.equals(""))
        {
            return Orders;
        }
        String terms[] = searchTerm.trim().contains(" ")? searchTerm.split(" "): new String[]{searchTerm};
        for(Order c : Orders)
        {
            for(String s: terms)
            {
                if(c.toString().contains(s))
                {
                    results.add(c);
                    break;
                }
            }
        }
        return results;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_data);
        findViews();
    }
}
