package com.example.secondhomework.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondhomework.R;
import com.example.secondhomework.models.User;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private ArrayList<User> users;

    public UserAdapter(ArrayList<User> users){
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_user,parent,false);
        UserViewHolder userViewHolder = new UserViewHolder(view);
        return userViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = users.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView name;
        private TextView username;
        private TextView email;
        private TextView street;
        private TextView suite;
        private TextView city;
        private TextView zipCode;
        private TextView lat;
        private TextView lng;
        private TextView phone;
        private TextView webSite;
        private TextView companyName;
        private TextView catchPhrase;
        private TextView bs;

        public UserViewHolder(View view){
            super(view);
            id = view.findViewById(R.id.user_id);
            name = view.findViewById(R.id.name_id);
            username = view.findViewById(R.id.username_id);
            email = view.findViewById(R.id.email_id);
            street = view.findViewById(R.id.street_id);
            suite = view.findViewById(R.id.suite_id);
            city = view.findViewById(R.id.city_id);
            zipCode = view.findViewById(R.id.zip_id);
            lat = view.findViewById(R.id.lat_id);
            lng = view.findViewById(R.id.lng_id);
            phone = view.findViewById(R.id.phone_id);
            webSite = view.findViewById(R.id.website_id);
            companyName = view.findViewById(R.id.company_name_id);
            catchPhrase = view.findViewById(R.id.catch_phrase_id);
            bs = view.findViewById(R.id.bs_id);
        }

        public void bind(User user){
            id.setText(user.getId());
            name.setText(user.getName());
            username.setText(user.getUsername());
            email.setText(user.getEmail());
            street.setText(user.getStreet());
            suite.setText(user.getSuite());
            city.setText(user.getCity());
            zipCode.setText(user.getZipCode());
            lat.setText(user.getLat());
            lng.setText(user.getLng());
            phone.setText(user.getPhone());
            webSite.setText(user.getWebSite());
            companyName.setText(user.getCompanyName());
            catchPhrase.setText(user.getCatchPhrase());
            bs.setText(user.getBs());
        }
    }
}
