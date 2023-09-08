package dev.jerry.soapwebservices.soap;

import com.javacourses.courses.CourseDetails;
import com.javacourses.courses.GetCourseDetailRequest;
import com.javacourses.courses.GetCourseDetailResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import org.springframework.ws.server.endpoint.annotation.Endpoint;


@Endpoint("")
public class CourseDetailsEndpoint {
    @PayloadRoot(namespace ="http://javacourses.com/courses", localPart = "GetCourseDetailsRequest")
    @ResponsePayload
    public GetCourseDetailResponse processCourseDetailsRequest(
            @RequestPayload
            GetCourseDetailRequest request){
        GetCourseDetailResponse response = new GetCourseDetailResponse();
        CourseDetails courseDetails = new CourseDetails();
        courseDetails.setId(request.getId());
        courseDetails.setName("Microservice Course");
        courseDetails.setDescription("This is a course on Microservices");
        return response;
    }
}
