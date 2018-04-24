package com.bignerdranch.android.bikeshare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Tom on 30/03/2018.
 */

public class ListFragment extends Fragment implements Observer {
    private static RidesDB sharedRidesHistory;

    private RecyclerView mRidesList;
    private RidesAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedRidesHistory = RidesDB.get(getActivity());
        sharedRidesHistory.addObserver(this);
    }

    @Override
    public void update(Observable o, Object data) {
        mAdapter.notifyDataSetChanged();
    }

    public class RideHolder extends RecyclerView.ViewHolder {
        private Ride mRide;

        private TextView mBikeName, mStartLocation, mStartTime, mEndLocation, mEndTime;

        public RideHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item, parent, false));

            mBikeName = itemView.findViewById(R.id.bike_name);

            mStartLocation = itemView.findViewById(R.id.start_location);
            mStartTime = itemView.findViewById(R.id.start_time);

            mEndLocation = itemView.findViewById(R.id.end_location);
            mEndTime = itemView.findViewById(R.id.end_time);
        }

        public void bind(Ride ride) {
            mRide = ride;

            mBikeName.setText(mRide.getBikeName());

            mStartLocation.setText(mRide.getStartLocation());
            mStartTime.setText(mRide.getFormattedStartDateTime());

            mEndLocation.setText(mRide.getEndLocation());
            mEndTime.setText(mRide.getFormattedEndDateTime());
        }
    }

    private class RidesAdapter extends RecyclerView.Adapter<RideHolder> {
        private List<Ride> mRides;

        public RidesAdapter(List<Ride> rides) {
            mRides = rides;
        }

        @Override
        public RideHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            return new RideHolder(layoutInflater, parent);
        }

        @Override
        public void onBindViewHolder(RideHolder holder, int position) {
            Ride ride = mRides.get(position);
            holder.bind(ride);
        }

        @Override
        public int getItemCount() {
            return mRides.size();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        mRidesList = view.findViewById(R.id.list_recycler_view);
        mRidesList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new RidesAdapter(sharedRidesHistory.getRidesDB());
        mRidesList.setAdapter(mAdapter);

        return view;
    }
}
