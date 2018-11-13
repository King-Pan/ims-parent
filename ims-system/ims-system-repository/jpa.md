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


```java
Criteria<User> criteria = new Criteria<>();  
    criteria.add(Restrictions.eq("name", "test")); //等于 name = ‘test’  
    criteria.add(Restrictions.like("name", "test", Criterion.MatchMode.ANYWHERE)); //等于 name like %test%  
    criteria.add(Restrictions.between("age", 1 , 20));  //age between(1, 20)  
    criteria.add(Restrictions.isNotEmpty("name")); // ISNOTEMPTY(name)  
    List<String> list = new ArrayList();  
    list.add("Alice");  
    list.add("Mick");  
    criteria.add(Restrictions.in("name", list));  // name in ('Alice','Mick')  
  
    criteria.add(Restrictions.eq(Projections.Length("name"), 5));  // length(name) = 5  
    criteria.add(Restrictions.gt(Projections.Max("name"), 5));  // max(name) = 5  
    criteria.add(Restrictions.or(Restrictions.eq("name", "tt"),Restrictions.eq("name", "qq"))); //(name = 'tt' or name = 'qq')  
    List<User> userList = userRepository.findAll(criteria);  

--------------------- 
作者：stupid_qb 
来源：CSDN 
原文：https://blog.csdn.net/stupid_qb/article/details/79911164 
版权声明：本文为博主原创文章，转载请附上博文链接！
```