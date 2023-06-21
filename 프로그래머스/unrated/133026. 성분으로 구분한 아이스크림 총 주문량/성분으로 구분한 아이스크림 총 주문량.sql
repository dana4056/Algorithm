-- 성분 타입, 타입에 대한 총 주문량 조회
-- 총 주문량 오름차순
-- 총 주문량 컬럼명 -> TOTAL_ORDER

SELECT INGREDIENT_TYPE, SUM(TOTAL_ORDER) AS TOTAL_ORDER
FROM FIRST_HALF AS F JOIN ICECREAM_INFO AS I
ON F.FLAVOR = I.FLAVOR
GROUP BY INGREDIENT_TYPE
ORDER BY TOTAL_ORDER


# [FIRST_HALF] - 상반기 주문 정보
# SHIPMENT_ID	출하번호
# FLAVOR	    아이스크림 맛 (v)
# TOTAL_ORDER   총 주문량

# [ICECREAM_INFO] - 아이스크림 성분 정보
# FLAVOR            아이스크림 맛  (v)
# INGREDIENT_TYPE   성분 타입
        # ㄴsugar_based: 설탕
        # ㄴfruit_based: 과일
        

