package uk.gov.ida.notification.session.storage;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import org.opensaml.storage.StorageRecord;


public class RedisStorageRecord extends StorageRecord {
    public RedisStorageRecord(String value, Long expiration) {
        super(value, expiration);
    }

    public RedisStorageRecord(String value, Long expiration, Long version) {
        this(value, expiration);
        this.setVersion(version);
    }

    public Map<String, String> toMap() {
        return ImmutableMap.of(
            "value", getValue(),
            "version", Long.toString(getVersion()),
            "expiration", Long.toString(getExpiration()));
    }
}
