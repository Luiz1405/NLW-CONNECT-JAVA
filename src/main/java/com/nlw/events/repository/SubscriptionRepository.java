package com.nlw.events.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.nlw.events.dto.SubscriptionRankingItem;
import com.nlw.events.model.Event;
import com.nlw.events.model.Subscription;
import com.nlw.events.model.User;

public interface SubscriptionRepository extends CrudRepository<Subscription, Integer> {
    public Subscription findByEventAndSubscriber(Event evet, User user);

    @Query(value = "select count(subscription_number) as Quantidade, indication_user_id, user_name as \"Nome do Usuário\" " +
    "from tbl_subscription inner join tbl_user"
    + "on tbl_subscription.indication_user_id = tbl_user.user_id"
    + "where indication_user_id is not null "
    + "and event_id : eventId"
    + "group by indication_user_id, user_name "
    + " Order by quantidade desc", nativeQuery = true)
    public List<SubscriptionRankingItem> generateRanking(@Param("eventId")Integer eventId);
}


