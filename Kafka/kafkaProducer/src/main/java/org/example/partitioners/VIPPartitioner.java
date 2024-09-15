package org.example.partitioners;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;
import org.apache.kafka.common.utils.Utils;

import java.util.List;
import java.util.Map;

public class VIPPartitioner implements Partitioner {
    /**
     * @param topic      The topic name
     * @param key        The key to partition on (or null if no key)
     * @param keyBytes   The serialized key to partition on( or null if no key)
     * @param value      The value to partition on or null
     * @param valueBytes The serialized value to partition on or null
     * @param cluster    The current cluster metadata
     * @return
     */

    /**
     * @param configs
     */
    @Override
    public void configure(Map<String, ?> configs) {

    }
    public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.availablePartitionsForTopic(topic);
        if(((String)key).equals("Rishabh")){
            return 7;
        }
        return Math.abs(Utils.murmur2(keyBytes))%partitions.size()-1;
    }

    @Override
    public void close() {

    }

}
