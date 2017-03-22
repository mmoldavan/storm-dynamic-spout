package com.salesforce.storm.spout.sideline;

import org.apache.storm.tuple.Values;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Simple test around KafkaMessage.
 */
public class KafkaMessageTest {

    /**
     * Tests the constructor + getters.
     */
    @Test
    public void testConstructor() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";
        final TupleMessageId expectedTupleMessageId = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);


        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;
        final Values expectedValues = new Values(expectedValue1, expectedValue2, expectedValue3);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage = new KafkaMessage(expectedTupleMessageId, expectedValues);

        // Validate TupleMessageId
        assertEquals("Got expected TupleMessageId", expectedTupleMessageId, kafkaMessage.getTupleMessageId());
        assertEquals("Got expected topic", expectedTopic, kafkaMessage.getTopic());
        assertEquals("Got expected partition", expectedPartition, kafkaMessage.getPartition());
        assertEquals("Got expected offset", expectedOffset, kafkaMessage.getOffset());

        // Validate Values
        assertEquals("Got expected Values", expectedValues, kafkaMessage.getValues());
        assertEquals("Got expected Values count", 3, kafkaMessage.getValues().size());
        assertEquals("Got expected Value1", expectedValue1, kafkaMessage.getValues().get(0));
        assertEquals("Got expected Value2", expectedValue2, kafkaMessage.getValues().get(1));
        assertEquals("Got expected Value3", expectedValue3, kafkaMessage.getValues().get(2));
    }

    /**
     * Ensures that the same instance is equal to itself.
     */
    @Test
    public void testEqualsSameInstance() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";
        final TupleMessageId expectedTupleMessageId = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);


        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;
        final Values expectedValues = new Values(expectedValue1, expectedValue2, expectedValue3);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage = new KafkaMessage(expectedTupleMessageId, expectedValues);

        assertTrue("Should be equal", kafkaMessage.equals(kafkaMessage));
    }

    /**
     * Tests equality.
     */
    @Test
    public void testEqualsDifferentInstancesSameInnerObjects() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";
        final TupleMessageId expectedTupleMessageId = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);


        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;
        final Values expectedValues = new Values(expectedValue1, expectedValue2, expectedValue3);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(expectedTupleMessageId, expectedValues);
        final KafkaMessage kafkaMessage2 = new KafkaMessage(expectedTupleMessageId, expectedValues);

        // Validate
        assertTrue("Should be equal", kafkaMessage1.equals(kafkaMessage2));
        assertTrue("Should be equal", kafkaMessage2.equals(kafkaMessage1));
    }

    /**
     * Tests equality.
     */
    @Test
    public void testEqualsDifferentInstancesSameInnerTupleMessageId() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";
        final TupleMessageId expectedTupleMessageId = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);

        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(expectedTupleMessageId, new Values(expectedValue1, expectedValue2, expectedValue3));
        final KafkaMessage kafkaMessage2 = new KafkaMessage(expectedTupleMessageId, new Values(expectedValue1, expectedValue2, expectedValue3));

        // Validate
        assertTrue("Should be equal", kafkaMessage1.equals(kafkaMessage2));
        assertTrue("Should be equal", kafkaMessage2.equals(kafkaMessage1));
    }

    /**
     * Tests equality.
     */
    @Test
    public void testEqualsDifferentInstancesSameValueInstances() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";

        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;
        final Values expectedValues = new Values(expectedValue1, expectedValue2, expectedValue3);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId), expectedValues);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage2 = new KafkaMessage(new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId), expectedValues);

        // Validate
        assertTrue("Should be equal", kafkaMessage1.equals(kafkaMessage2));
        assertTrue("Should be equal", kafkaMessage2.equals(kafkaMessage1));
    }

    /**
     * Tests equality.
     */
    @Test
    public void testEqualsDifferentInstances() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";

        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId), new Values(expectedValue1, expectedValue2, expectedValue3));

        // Create KafkaMessage
        final KafkaMessage kafkaMessage2 = new KafkaMessage(new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId), new Values(expectedValue1, expectedValue2, expectedValue3));

        // Validate
        assertTrue("Should be equal", kafkaMessage1.equals(kafkaMessage2));
        assertTrue("Should be equal", kafkaMessage2.equals(kafkaMessage1));
    }

    /**
     * Tests equality when not equal tuple message Ids.
     */
    @Test
    public void testNotEqualsDifferentTupleMessageIds() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";

        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;

        // Create tupleMessageIds that are different
        final TupleMessageId tupleMessageId1 = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);
        final TupleMessageId tupleMessageId2 = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset + 1, expectedConsumerId);

        // Create values that are the same
        final Values values1 = new Values(expectedValue1, expectedValue2, expectedValue3);
        final Values values2 = new Values(expectedValue1, expectedValue2, expectedValue3);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(tupleMessageId1, values1);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage2 = new KafkaMessage(tupleMessageId2, values2);

        // Validate
        assertFalse("Should NOT be equal", kafkaMessage1.equals(kafkaMessage2));
        assertFalse("Should NOT be equal", kafkaMessage2.equals(kafkaMessage1));
    }

    /**
     * Tests equality when not equal values.
     */
    @Test
    public void testNotEqualsDifferentValues() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";

        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;

        // Create tupleMessageIds that are the same
        final TupleMessageId tupleMessageId1 = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);
        final TupleMessageId tupleMessageId2 = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);

        // Create values that are different
        final Values values1 = new Values(expectedValue1, expectedValue2, expectedValue3);
        final Values values2 = new Values(expectedValue1, expectedValue2);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(tupleMessageId1, values1);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage2 = new KafkaMessage(tupleMessageId2, values2);

        // Validate
        assertFalse("Should NOT be equal", kafkaMessage1.equals(kafkaMessage2));
        assertFalse("Should NOT be equal", kafkaMessage2.equals(kafkaMessage1));
    }

    /**
     * Tests equality when not equal values.
     */
    @Test
    public void testNotEqualsAgainstNull() {
        // Define TupleMessageId components
        final String expectedTopic = "MyTopic";
        final int expectedPartition = 2;
        final long expectedOffset = 31337L;
        final String expectedConsumerId = "MyConsumerId";

        // Define expected values components
        final String expectedValue1 = "This is value 1";
        final String expectedValue2 = "This is value 2";
        final Long expectedValue3 = 42L;

        // Create tupleMessageId
        final TupleMessageId tupleMessageId1 = new TupleMessageId(expectedTopic, expectedPartition, expectedOffset, expectedConsumerId);

        // Create values
        final Values values1 = new Values(expectedValue1, expectedValue2, expectedValue3);

        // Create KafkaMessage
        final KafkaMessage kafkaMessage1 = new KafkaMessage(tupleMessageId1, values1);

        // Create KafkaMessage that is null
        final KafkaMessage kafkaMessage2 = null;

        // Validate
        assertFalse("Should NOT be equal", kafkaMessage1.equals(kafkaMessage2));
    }
}