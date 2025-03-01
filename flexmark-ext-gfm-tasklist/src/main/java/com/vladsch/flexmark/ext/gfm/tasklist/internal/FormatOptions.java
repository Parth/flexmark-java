package com.vladsch.flexmark.ext.gfm.tasklist.internal;

import com.vladsch.flexmark.ext.gfm.tasklist.TaskListExtension;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemCase;
import com.vladsch.flexmark.ext.gfm.tasklist.TaskListItemPlacement;
import com.vladsch.flexmark.util.data.DataHolder;
import com.vladsch.flexmark.util.data.MutableDataHolder;
import com.vladsch.flexmark.util.data.MutableDataSetter;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("WeakerAccess")
public class FormatOptions implements MutableDataSetter {
    public final TaskListItemCase taskListItemCase;
    public final TaskListItemPlacement taskListItemPlacement;

    public FormatOptions() {
        this(null);
    }

    public FormatOptions(DataHolder options) {
        taskListItemCase = TaskListExtension.FORMAT_LIST_ITEM_CASE.get(options);
        taskListItemPlacement = TaskListExtension.FORMAT_LIST_ITEM_PLACEMENT.get(options);
    }

    @NotNull
    @Override
    public MutableDataHolder setIn(@NotNull MutableDataHolder dataHolder) {
        dataHolder.set(TaskListExtension.FORMAT_LIST_ITEM_CASE, taskListItemCase);
        dataHolder.set(TaskListExtension.FORMAT_LIST_ITEM_PLACEMENT, taskListItemPlacement);
        return dataHolder;
    }
}
