package com.rss.ReligionServer.dao;

import com.rss.ReligionServer.model.mapping.AddressMapping;

public interface AddressDao {
    long create(AddressMapping addressMapping);
    AddressMapping retrieveById(int id);
    long update(AddressMapping addressMapping);
    long remove(int id);
}
