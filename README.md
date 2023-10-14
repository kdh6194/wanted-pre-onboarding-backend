# wanted-pre-onboarding-backend

# 서비스 개요
    - 본 서비스는 기업의 채용을 위한 웹 서비스 입니다.
    - 회사는 채용공고를 생성하고, 이에 사용자는 지원합니다.


## 서비스 기술 스택
    - Java 11
    - SpringBoot 2.7.17
    - JPA
    - MariaDB 2.7.4

## 요구사항 분석
    1. 채용공고를 등록합니다.
    2. 채용공고를 수정합니다.
    3. 채용공고를 삭제합니다.
    4-1. 채용공고 목록을 가져옵니다.
    4-2. 채용공고 검색 기능 구현
    5. 채용 상세 페이지를 가져옵니다.

## API Docs - localhost:8080

### 1. 채용공고 등록

    POST /employee/upload
    Content-Type: application/json

- RequestBody
```json
{
  "company_no": 1,
  "position": "백엔드 주니어 개발자",
  "compensation": 1000000,
  "content": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skill": "Java"
}
```

- ResoponseBody
```json
{
  "company_no": 1,
  "company_name": "원티드랩",
  "country": "KOREA",
  "location": "SEOUL",
  "position": "백엔드 주니어 개발자",
  "compensation": 1000000,
  "skill": "Java"
}
```

### 2. 채용공고 수정
    PUT /employee/update/{id}
    Content-Type: application/json

- RequestBody
```json
{
  "position": "백엔드 주니어 개발자",
  "compensation": 2000000,
  "content": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skill": "Python"
}
```

### 3. 채용공고 삭제
    DELETE /employee//delete/{id}

### 4-1. 채용공고 목록
    GET /employee/list

- ResoponseBody
```json
[
  {
    "company_no": 1,
    "company_name": "사무실1",
    "country": "KOREA",
    "location": "SEOUL",
    "position": "백엔드 주니어 개발자",
    "compensation": 1000000,
    "skill": "Python"
  },
  {
    "company_no": 2,
    "company_name": "사무실1",
    "country": "KOREA",
    "location": "SEOUL",
    "position": "백엔드 주니어 개발자",
    "compensation": 1000000,
    "skill": "Java"
  },
  {
    "company_no": 3,
    "company_name": "사무실2",
    "country": "KOREA",
    "location": "BUSAN",
    "position": "백엔드 주니어 개발자",
    "compensation": 1000000,
    "skill": "Go"
  }
]
```

### 4-2. 채용공고 검색
    GET /employee/search

- ResoponseBody
```json
[
   {
    "company_no": 2,
    "company_name": "사무실1",
    "country": "KOREA",
    "location": "SEOUL",
    "position": "백엔드 주니어 개발자",
    "compensation": 1000000,
    "skill": "Java"
  }
]
```

### 5. 채용공고 상세 페이지
    GET /employee/list/{id}

- ResoponseBody
```json
{
  "company_no": 2,
  "company_name": "사무실1",
  "country": "KOREA",
  "location": "SEOUL",
  "position": "백엔드 주니어 개발자",
  "compensation": 1000000,
  "content": "사무실2에서 프론트 엔드 주니어 개발자를 채용합니다. 자격요건은..",
  "skill": "Java"
}
```