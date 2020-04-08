# Synchronous/ Asynchronous
호출되는 함수의 작업 완료 여부를 누가 신경쓰느냐에 따라 구분

### Synchronous
<ul>
<li>호출하는 함수가 호출되는 함수의 작업완료 후 리턴을 기다림
<li>호출된 함수의 리턴하는 시간과 결과를 반환하는 시간이 일치함
</ul>

### Asynchronous
<ul>
<li>호출되는 함수의 작업완료되면 호출되는 함수가 전달받은 callback을 실행하고 호출하는 함수는 작업 완료 여부를 신경 안씀
<li>호출된 함수의 리턴하는 시간과 결과를 반환하는 시간이 일치 하지 않음
<li>별도의 쓰레드로 빼서 실행하고 완료되면 호출하는 측에 알려줌
</ul>

# Blocking/ Non-Blocking
<ul>
<li>호출된 함수가 바로 리턴하는지 아닌지에 따라 구분
<li>Non-Blocking은 제어문 수준에서 지체없이 반환
</ul>

### reference
<a href="https://velog.io/@codemcd/Sync-VS-Async-Blocking-VS-Non-Blocking-sak6d01fhx">https://velog.io/@codemcd/Sync-VS-Async-Blocking-VS-Non-Blocking-sak6d01fhx</a>
<a href="https://homoefficio.github.io/2017/02/19/Blocking-NonBlocking-Synchronous-Asynchronous/">https://homoefficio.github.io/2017/02/19/Blocking-NonBlocking-Synchronous-Asynchronous/</a>
