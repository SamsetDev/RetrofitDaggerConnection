package sample.sam.com.daggerretrofitconnection.view.ui.base;


import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Copyright (C) DaggerRetrofitConnection - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited Proprietary and confidential.
 * <p>
 * Created by samset on 23/03/19 at 2:19 PM for DaggerRetrofitConnection .
 */

public abstract class BaseAdapter<Type extends RecyclerView.ViewHolder, Data> extends RecyclerView.Adapter<Type>{

    public abstract void setData(List<Data> data);
}