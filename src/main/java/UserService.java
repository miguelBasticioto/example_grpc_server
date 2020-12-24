import io.grpc.stub.StreamObserver;

public class UserService extends UserGrpc.UserImplBase {

    @Override
    public void login(UserOuterClass.LoginRequest request, StreamObserver<UserOuterClass.APIResponse> responseObserver) {
        System.out.println("Login");

        String username = request.getUsername();
        String password = request.getPassword();

        UserOuterClass.APIResponse.Builder response = UserOuterClass.APIResponse.newBuilder();
        if (username.equals(password)) {
            response.setResponseCode(0).setResponseMessage("SUCCESS");
        } else {
            response.setResponseCode(100).setResponseMessage("ERROR");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    @Override
    public void logout(UserOuterClass.Empty request, StreamObserver<UserOuterClass.APIResponse> responseObserver) {
        System.out.println("Logout");

        UserOuterClass.APIResponse.Builder response = UserOuterClass.APIResponse.newBuilder();

        response.setResponseCode(0).setResponseMessage("SUCCESS");

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
