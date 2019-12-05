package com.example.mywhatsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class TabAccessorAdapter extends FragmentPagerAdapter {


    public TabAccessorAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {


        switch(i)
        {
            case 0:
                CallsFragment callsFragment = new CallsFragment();
                return  callsFragment;
            case 1:
                ChatsFragment chatsFragment = new ChatsFragment();
                return chatsFragment;

            case 2:
                GroupsFragment groupsFragment = new GroupsFragment();
                return  groupsFragment;
            default:
                return  null;


        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position)
        {
            case 0:

                return "CALLS";
            case 1:

                return  "CHATS";

            case 2:

                return  "GROUPS";
            default:
                return  null;


        }
    }
}
