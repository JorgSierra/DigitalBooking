import { render, waitFor } from "@testing-library/react";
import Footer from "./Footer";
import "@testing-library/jest-dom";

describe("Footer", () => {
  it("social media div renders", async () => {
    const { getByTestId } = render(<Footer />);

    await waitFor(() => {
      const socialMedia = getByTestId("footer-social-media");
      expect(socialMedia).toBeInTheDocument();
    });
  });

  it("copyrights p is rendered", () => {
    const { getByTestId } = render(<Footer />);

    const copyright = getByTestId("footer-copyrights");

    expect(copyright).toBeInTheDocument();
  });
});
