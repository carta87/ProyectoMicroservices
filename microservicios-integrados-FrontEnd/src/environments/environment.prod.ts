export const environment = {
  production: true,
  name: 'production',

  //local
  //apiUrlAuth: 'http://localhost:8080/auth-micro',
  //apiUrlStudent: 'http://localhost:8080/student-micro/student',
  //apiUrlCourse: 'http://localhost:8080/course-micro/course'

  //azure
  apiUrlAuth: 'https://web-microservicios-gateway-b8epcnfwd7c6evak.centralus-01.azurewebsites.net/auth-micro',
  apiUrlStudent: 'https://web-microservicios-gateway-b8epcnfwd7c6evak.centralus-01.azurewebsites.net/student-micro/student',
  apiUrlCourse: 'https://web-microservicios-gateway-b8epcnfwd7c6evak.centralus-01.azurewebsites.net/course-micro/course'
};
