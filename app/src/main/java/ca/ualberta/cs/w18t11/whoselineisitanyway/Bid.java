package ca.ualberta.cs.w18t11.whoselineisitanyway;

import java.math.BigDecimal;

public class Bid
{
    final private String providerId;

    final private String taskId;

    final private BigDecimal value;

    Bid(final String providerId, final String taskId, final BigDecimal value) throws IllegalArgumentException
    {
        if (value.compareTo(BigDecimal.ONE) < 0)
        {
            throw new IllegalArgumentException("Bid value must be greater than 0");
        }

        if (providerId.isEmpty())
        {
            throw new IllegalArgumentException("Provider ID cannot be an empty string");
        }

        this.providerId = providerId;
        this.taskId = taskId;
        this.value = value;
    }

    final String getProviderId() { return this.providerId; }

    final String getTaskId() { return this.taskId; }

    final BigDecimal getValue() { return this.value; }
}
