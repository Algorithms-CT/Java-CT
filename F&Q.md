## F&Q (자주하는 질문)

### 1. 알고리즘(코딩테스트) 진행 방식

**1-1.** 각자 Part 1~4 문제들을 일주일에 정해진 양만큼 푼다.

**1-2.** 푼 문제들을 어떻게 풀었는지 /** 주석을 통해 설명한다. (ex. 사용한 라이브러리(API), 시간복잡도 - 더 빨리 풀 수 있는 방법이 있는가? , 전체적인 동작 알고리즘 등등... )  

**1-3.** 또한 자신이 이 문제를 풀며 안 새로운 사실에 대해서도 공유하면 좋을 것 같다. (ex. 블로그 공유 등등... )

**1-4.** 문제를 도저히 풀지 못하고 답안을 보았을 때는 풀지 못한 문제라고 표시를 해둔 후 자신이 풀지 못한 간단한 이유와 함께 다시 혼자만의 힘으로 풀어 제출한다.

**1-5.** 제출은 Pull Request를 통해 제출한다.

**1-6.** 스터디는 같은 문제에 대해 여러 다른 코드를 보기 위해 제작하였다. (ps. 이후 파이썬, c++ 인원도 구해볼까 한다.)

### 2. Pull Request하는 방법?

#### **2-1.** 먼저 지금 이 조직의 리포지토리를 나의 origin(내 깃허브)에 Fork해온다.

![1|500](https://github.com/Algorithms-CT/Java_CT/assets/113106136/c2c9e0b6-c5a2-4b88-8886-d169ddb80e53)
![2](https://github.com/Algorithms-CT/Java_CT/assets/113106136/9e65ff4f-cc47-49c0-93c4-dbda66207c40)
![3](https://github.com/Algorithms-CT/Java_CT/assets/113106136/d0cc9fd3-74f9-48c6-95a9-9523a00087f1)

- Repository 이름은 원하는대로 설정하면 된다.

#### **2-2.** 이후 자신인 사용하는 IDE (IntelliJ, Eclipse ...)를 통해 Java 클래스를 만들 수 있는 폴더를 하나 만든다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/3fdbf096-613c-4fef-ba8b-484f1be9b134)

- 원하는 local 장소에 project를 만들면 폴더가 하나 생길 것이다.

#### **2-3.** 그럼 폴더를 IDE에서 열어서 Terminal을 열어준다.

- 아래 그림은 Intellij terminal 여는 방법이다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/edab7bc8-e0f2-4c4c-a554-c219ffc8995b)

#### **2-4.** 다음은 그 폴더에 아까 Fork해온 리포지토리를 Clone 해올 것이다. (이제부터 코드 블럭에 있는 코드는 모두 터미널에 작성한다)

```bash
git clone <레포지토리 URL>     // 혹시 몰라서 말하는 거지만 <> 는 작성하면 안된다.
```

- 레포지토리 url은 Fork 해온 내 리포지토리!!! 에 url을 복사해와서 Terminal에 작성해야한다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/00073543-b61e-45e2-83a2-bca175842959)

#### **2-5.** git init한다.

```bash
git init
```

#### **2-6.** remote 설정

```bash
git remote add father <원본 저장소 url>   // 원본 저장소 url은 조직의 url을 작성한다.
```

- 위에서도 말했지만 원본 저장소 url은 조직의 url을 가져와야한다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/519328cd-8d24-44c0-9b1c-9d2f9d3c597a)

- 앞에 설정한 url 두개는 서로 다르니 주의하자!!!! 꼭

#### **2-7.** git add. / git commit 

```bash
git add .
git commit -m "원하는 커밋 메시지"
```

#### **2-8.** 나의 리포지토리 url remote 설정하기

```bash
git remote add origin <나의 리포지토리 url>
```
- 이 url은 아까 clone할때 사용한 내 리포지토리 url이다.
- git remote -v 를 통해 origin하고 upstream 리포지토리가 설정된 것을 볼 수 있을것이다.
- 결과는 다음과 같아야한다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/56f2a8dc-25b3-4fde-a2f9-081f3f3e323f)

- 물론 자신의 리포지토리 url은 다르다. 조직만 같다.

#### **2-9.** branch 생성

```bash
git branch <branch 이름>  // branch이름은 자기 이름 이니셜 + 학번 마지막 5자리로 통일한다.
git checkout <branch 이름>
git checkout -b <branch 이름>
```

> 위에서도 말했듯이 **branch 이름은 자기 이름 이니셜 + 학번 마지막 5자리**로 통일한다.

- 정상적으로 branch생성 후 이동이 되었으면 다음과 같은 그림과 같은것이다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/90d1937e-8246-476a-9f60-e9e0ea7ef620)

- 이제 해당 브랜치에서만 작업하면 된다.

#### **2-10.** .gitignore 생성

- 우리는 파일중에서 올리지 말아야할 파일들이 있다.
- .gitignore을 통해서 push할때 올라가지 말아야할 파일들을 설정해 준다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/bee66a71-2dd0-423d-a0c8-dead775f8c4a)

- new에서 file .gitignore이름의 파일을 생성해준다.
- 여기서 out , .idea, .gitignore, java_ct.iml은 올라가지 않도록 적어준다.
- 추가적으로 올리고 싶지 않은 파일이 있다면 설정해주자.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/8ad89ec2-aa87-4e51-bf5e-8ab9d9a339b2)

#### **2-11.** 코드 작업 후 add/commit/push

- 코드를 작성하고 어떤 파일이 modified 상태라면

```bash
git rm -r --cached .   // . 붙여야 한다!!!!
git add .   // 특정 파일만 올리고 싶으면 . 대신 파일 이름 
git commit -m "clear tutorial!"
git push origin <나의 브랜치 이름>
```

- git rm -r --cached . 는 .gitignore을 설정했음에도 적용이 되지 않을 때
- 해결해주는 코드이다.

- 어쨋든 위의 과정을 마치고 자신의 리포지토리의 내가 만든 브랜치에 들어가보면 데이터가 최신화 되고
- Pull request 요청도 들어올 것이다.

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/61ae19bb-7e8d-45e3-a40e-d75024010511)

![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/df938f0e-471f-4313-8976-058cb6a5afaf)

첫번째 내 리포지토리의 내가 만든 브랜치에서 조직의 main 리포지토리로 화살표 방향이 잘 되어있는지 확인하고 

두번째 able to merge를 확인하고 

세번째 create pull request를 누른다.

그럼 PUll request 완료!

- 혹시라도 There isn't anything to compare이란 문구가 나온다면
- 터미널에 해당 코드 한번 작성해주자

```bash
git pull origin main --allow-unrelated-histories
```
이후 다시 들어가면 잘 나타날 것이다.

> Pull request 해 놓으면 Merge는 제가 해드리겠습니다.
> 또한 Conflict 발생 시 말씀해주세요

#### Pull Request에 대해 잘 정리된 블로그 (https://inpa.tistory.com/entry/GIT-%E2%9A%A1%EF%B8%8F-%EA%B9%83%ED%97%99-PRPull-Request-%EB%B3%B4%EB%82%B4%EB%8A%94-%EB%B0%A9%EB%B2%95-folk-issue)

### 3. 클래스 이름은 어떻게 하나요?

> 클래스파일 이름은 다음과 같이 통일합니다.
> 파트 1 문제를 풀고 있을때 예시입니다.
> Pt1_문제 번호_자신의 이름 영문 이니셜(뒤 두자리)

 ![image](https://github.com/Algorithms-CT/Java_CT/assets/113106136/fb5c4bff-c1a0-4b60-b81d-01bb591bd72c)













