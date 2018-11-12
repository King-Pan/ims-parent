## 扩展

```java
QueryParams<PcardOrder> queryParams = new QueryParams<>();
        //使用Specification条件查询,使用JPQL字段查询
        queryParams
                .and(Filter.eq("acctId","0014779934917371041"),Filter.ne("orderAmt",0L),
                        Filter.eq("orderRespCd","00"))
                .or(Filter.eq("orderTypeId","A003"),Filter.eq("orderTypeId","A007"),
                        Filter.eq("orderTypeId","A021"),Filter.eq("orderTypeId","A018"))
                .orderDESC("createTime");

        Page<PcardOrder> JPQLlist = pcardOrderRepository.findAll(queryParams,new PageRequest(0,2));
        
        //构造出来的条件
        where
        1=1 
        and pcardorder0_.acct_id=? 
        and pcardorder0_.order_amt<>0 
        and pcardorder0_.order_resp_cd=? 
        and (
            0=1 
            or pcardorder0_.order_type_id=? 
            or pcardorder0_.order_type_id=? 
            or pcardorder0_.order_type_id=? 
            or pcardorder0_.order_type_id=?
        ) 
    order by
        pcardorder0_.create_time desc limit ?

```


## 


```java
JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        JPAQuery<Tuple> jpaQuery = queryFactory.select(QTCity.tCity,QTHotel.tHotel)
                                        .from(QTCity.tCity)
                                        .leftJoin(QTHotel.tHotel)
                                        .on(QTHotel.tHotel.city.longValue().eq(QTCity.tCity.id.longValue()));
        //添加查询条件
        jpaQuery.where(predicate);
        //拿到结果
        return jpaQuery.fetch();
```


https://www.jianshu.com/p/2b68af9aa0f5

```java
   @PersistenceContext
    protected EntityManager em;
```


```java
//让Spring管理JPAQueryFactory
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
```