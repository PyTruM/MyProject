SELECT 
t1.id,
t1.country_code,
t2.name country_name,
t3.language,
t3.is_official,
sum(t1.population) sum_pop
FROM city t1
join country t2 on t2.code = t1.country_code
join country_language t3 on t3.country_code = t1.country_code
group by t2.name
order by sum_pop desc;
