package com.kodjevlar.interfaces;

import com.kodjevlar.models.ContentItem;
import org.bson.types.ObjectId;

public interface ContentItemDAOI {
    public ContentItem getById(ObjectId contentItemId);
    public ContentItem save(ContentItem contentItem);
    public void Remove(ContentItem contentItem);
}
